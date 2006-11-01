/* 
* Copyright (C) 2002-2006 XimpleWare, info@ximpleware.com
*
* This program is free software; you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation; either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
*/
#include "xpath1.h"

filterExpr *createFilterExpr(expr *e1, Predicate *pr){
	exception e;
	filterExpr *fe = malloc(sizeof(filterExpr));
	if (fe ==NULL){
		e.et = out_of_mem;
		e.msg = "filterExpr allocation failed";
		Throw e;
	}
	fe->freeExpr = &freeFilterExpr;
	fe->evalBoolean = &evalBoolean_fe;
	fe->evalNodeSet = &evalNodeSet_fe;
	fe->evalNumber  = &evalNumber_fe;
	fe->evalString  = &evalString_fe;
	fe->isNumerical = &isNumerical_fe;
	fe->isBoolean = &isBoolean_fe;
	fe->isString =  &isString_fe;
	fe->isNodeSet = &isNodeSet_fe;
	fe->requireContextSize = &requireContextSize_fe;
	fe->setContextSize = &setContextSize_fe;
	fe->setPosition = &setPosition_fe;
	fe->reset = &reset_fe;
	fe->toString = &toString_fe;

	fe->e = e1;
	fe->p = pr;

	return fe;
	
}
void freeFilterExpr(filterExpr *fe){
	if (fe == NULL) return;
	fe->e->freeExpr(fe->e);
	freePredicate(fe->p);
	free(fe);
}

int	evalNodeSet_fe (filterExpr *fe,VTDNav *vn){
	int i,a;
	if (fe->first_time && requireContextSize_p(fe->p)){
		fe->first_time = FALSE;
		i = 0;
		while(fe->e->evalNodeSet(fe->e,vn)!=-1)
			i++;
		setContextSize_p(fe->p,i);
		reset2_fe(fe,vn);
	}
	a = fe->e->evalNodeSet(fe->e,vn);
	while (a!=-1){
		if (eval_p(fe->p,vn)==TRUE){
			//p.reset();
			return a;				
		}else {
			//p.reset();
			a = fe->e->evalNodeSet(fe->e,vn);
		}			
	}
	return -1;		
}
double	evalNumber_fe (filterExpr *fe,VTDNav *vn){
	double d = 0.0;
	exception e;
	int a = -1;
	int size;
	push2(vn);
	size = vn->contextBuf2->size;
	Try {
		a =evalNodeSet_fe(fe,vn);
		if (a!=-1){
			if (getTokenType(vn,a)== TOKEN_ATTR_NAME){
				a ++;
			}else if (getTokenType(vn,a)== TOKEN_STARTING_TAG) {
				a = getText(vn);
			}
		}			  
	} Catch (e){
	}
	vn->contextBuf2->size = size;
	reset_fe(fe,vn);
	pop2(vn);
	Try{
		if (a!=-1) return parseDouble(vn,a);
	}Catch (e){
	}
	return 0/d;
}

UCSChar* evalString_fe  (filterExpr *fe,VTDNav *vn){
	exception e;
	int size,a;
	push2(vn);
	size = vn->contextBuf2->size;
	a = -1;
	Try {
		a = evalNodeSet_fe(fe,vn);
		if (a != -1) {
			if (getTokenType(vn,a) == TOKEN_ATTR_NAME) {
				a++;
			}
			if (getTokenType(vn,a) == TOKEN_STARTING_TAG) {
				a = getText(vn);
			}
		}
	} Catch (e) {
	}
	vn->contextBuf2->size = size;
	reset_fe(fe,vn);
	pop2(vn);
	Try {
		if (a != -1)
			return toString(vn,a);
	} Catch (e) {
		if (e.et = out_of_mem)
			Throw e;
	}
	return createEmptyString();
}
Boolean evalBoolean_fe (filterExpr *fe,VTDNav *vn){
	exception e;
	Boolean a = FALSE;
	int size;
	push2(vn);
	//record stack size
	size = vn->contextBuf2->size;
	Try{	
		a = (evalNodeSet_fe(fe,vn) != -1);
	}Catch (e){
	}
	//rewind stack
	vn->contextBuf2->size = size;
	reset_fe(fe,vn);
	pop2(vn);
	return a;
}
Boolean isBoolean_fe (filterExpr *fe){
	return FALSE;
}
Boolean isNumerical_fe (filterExpr *fe){
	return FALSE;
}
Boolean isString_fe (filterExpr *fe){
	return FALSE;
}
Boolean isNodeSet_fe (filterExpr *fe){
	return TRUE;
}
Boolean requireContextSize_fe(filterExpr *fe){
	return FALSE;
}
void reset_fe(filterExpr *fe, VTDNav *vn){
	reset2_fe(fe,vn);
	//vn.contextStack2.size = stackSize; 
	//position = 1;
	fe->first_time = TRUE;
}
void setContextSize_fe(filterExpr *fe,int s){
}
void setPosition_fe(filterExpr *fe,int pos){
}
void toString_fe(filterExpr *fe, UCSChar* string){
	wprintf(L"(");
	fe->e->toString(fe->e,string);
	wprintf(L")");
	toString_p(fe->p,string);
}
void reset2_fe(filterExpr *fe, VTDNav *vn){
	fe->e->reset(fe->e,vn);
	reset_p(fe->p,vn);
}