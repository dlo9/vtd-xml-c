/*
 * Created on Nov 29, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package DOMTest;

import java.io.File;
import java.io.FileInputStream;

import com.ximpleware.*;

/**
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class APTest {
	public static boolean test(String fileName){
		FastIntBuffer flb1 = new FastIntBuffer();
		FastIntBuffer flb2 = new FastIntBuffer();
		FastIntBuffer flb3 = new FastIntBuffer();
	try{
		int z = 0;
		VTDGen1 vg = new VTDGen1();
		File f = new File(fileName);
		byte[] ba = new byte[(int)f.length()];
		FileInputStream fis = new FileInputStream(f);
		fis.read(ba);
		vg.setDoc(ba);
		vg.parse(true);
		VTDNav vn =vg.getNav();
		if (vn.toElement(VTDNav.FIRST_CHILD)){
		 do{
		 	z++;
		    vn.sampleState(flb1);//leve1
		 } while(vn.toElement(VTDNav.NEXT_SIBLING));
		}
		//System.out.println("level1 occurance "+z);
		//System.out.println("flb2 size is :"+flb1.size());
		z=0;
		vn.toElement(VTDNav.ROOT);
		if (vn.toElement(VTDNav.FIRST_CHILD)){
			 do{
			 	if (vn.toElement(VTDNav.FIRST_CHILD)){
					 do{
					 	z++;
					    vn.sampleState(flb1); // level2
					 } while(vn.toElement(VTDNav.NEXT_SIBLING));
					 vn.toElement(VTDNav.PARENT);
					}
			 	
			 } while(vn.toElement(VTDNav.NEXT_SIBLING));
		}
		//System.out.println("level2 occurance "+z);
		//System.out.println("flb2 size is :"+flb1.size());
		z = 0;
		vn.toElement(VTDNav.ROOT);
		if (vn.toElement(VTDNav.FIRST_CHILD)){
			 do{
			 	if (vn.toElement(VTDNav.FIRST_CHILD)){
					 do{
					 	if (vn.toElement(VTDNav.FIRST_CHILD)){
							 do{
							 	z++;
							    vn.sampleState(flb1); // level3
							 } while(vn.toElement(VTDNav.NEXT_SIBLING));
							 vn.toElement(VTDNav.PARENT);
						}
					 } while(vn.toElement(VTDNav.NEXT_SIBLING));
					 vn.toElement(VTDNav.PARENT);
				}
			 } while(vn.toElement(VTDNav.NEXT_SIBLING));
			 vn.toElement(VTDNav.PARENT);
		}
		//System.out.println("level3 occurance "+z);
		//System.out.println("flb2 size is :"+flb1.size());
		z = 0;
		vn.toElement(VTDNav.ROOT);
		if (vn.toElement(VTDNav.FIRST_CHILD)){
			 do{
			 	if (vn.toElement(VTDNav.FIRST_CHILD)){
					 do{
					 	if (vn.toElement(VTDNav.FIRST_CHILD)){
							 do{
							 	if (vn.toElement(VTDNav.FIRST_CHILD)){
									 do{
									 	z++;
									    vn.sampleState(flb1); // level4
									 } while(vn.toElement(VTDNav.NEXT_SIBLING));
									 vn.toElement(VTDNav.PARENT);
								}
							 } while(vn.toElement(VTDNav.NEXT_SIBLING));
							 vn.toElement(VTDNav.PARENT);
						}
					 } while(vn.toElement(VTDNav.NEXT_SIBLING));
					 vn.toElement(VTDNav.PARENT);
				}
			 } while(vn.toElement(VTDNav.NEXT_SIBLING));
			 vn.toElement(VTDNav.PARENT);
		}
		//System.out.println("level4 occurance "+z);
		//System.out.println("flb2 size is :"+flb1.size());
		z= 0;
		vn.toElement(VTDNav.ROOT);
		AutoPilot ap = new AutoPilot(vn);
		ap.selectElement("level1:level1");
		while(ap.iterate()){
			z++;
			//System.out.println("index "+vn.getCurrentIndex()+": "+vn.toString(vn.getCurrentIndex()));
			vn.sampleState(flb2);
		}
		//System.out.println("level1 occurance "+z);
		//System.out.println("flb2 size is :"+flb2.size());
		z = 0;
		vn.toElement(VTDNav.ROOT);
		ap.selectElement("level2:level2");
		while(ap.iterate()){
			z++;
			vn.sampleState(flb2);
		}
		//System.out.println("level2 occurance "+z);
		//System.out.println("flb2 size is :"+flb2.size());
		z = 0;
		vn.toElement(VTDNav.ROOT);
		ap.selectElement("level3:level3");
		while(ap.iterate()){
			z++;
			vn.sampleState(flb2);
		}
		//System.out.println("level3 occurance "+z);
		//System.out.println("flb2 size is :"+flb2.size());
		z = 0;
		vn.toElement(VTDNav.ROOT);
		ap.selectElement("level4:level4");
		while(ap.iterate()){
			z++;
			
			vn.sampleState(flb2);
		}
		//System.out.println("level4 occurance "+z);
		//System.out.println("flb2 size is :"+flb2.size());
		z = 0;
		if (flb1.size()!=flb2.size()){
			return false;
		}
		for (int i=0;i<flb1.size();i++){
		  if (flb1.intAt(i)!= flb2.intAt(i))
		  	return false;
		}
	}catch (ParseException e){
		System.out.println("ParserException: "+e);
		e.printStackTrace();
		return false;
	}catch (NavException e){
		System.out.println("NavException:"+e);
		return false;
	}
	catch (Exception e){
		e.printStackTrace();
		System.out.println("other exceptions");
		return false;
	}
		return true;
		
	}

	public static boolean test2(String fileName){
		FastIntBuffer flb1 = new FastIntBuffer();
		FastIntBuffer flb2 = new FastIntBuffer();
		FastIntBuffer flb3 = new FastIntBuffer();
	try{
		int z = 0;
		VTDGen vg = new VTDGen();
		File f = new File(fileName);
		byte[] ba = new byte[(int)f.length()];
		FileInputStream fis = new FileInputStream(f);
		fis.read(ba);
		vg.setDoc(ba);
		vg.parse(true);
		VTDNav vn =vg.getNav();
		if (vn.toElement(VTDNav.FIRST_CHILD)){
		 do{
		 	z++;
		    vn.sampleState(flb1);//leve1
		 } while(vn.toElement(VTDNav.NEXT_SIBLING));
		}
		//System.out.println("level1 occurance "+z);
		//System.out.println("flb2 size is :"+flb1.size());
		z=0;
		vn.toElement(VTDNav.ROOT);
		if (vn.toElement(VTDNav.FIRST_CHILD)){
			 do{
			 	if (vn.toElement(VTDNav.FIRST_CHILD)){
					 do{
					 	z++;
					    vn.sampleState(flb1); // level2
					 } while(vn.toElement(VTDNav.NEXT_SIBLING));
					 vn.toElement(VTDNav.PARENT);
					}
			 	
			 } while(vn.toElement(VTDNav.NEXT_SIBLING));
		}
		//System.out.println("level2 occurance "+z);
		//System.out.println("flb2 size is :"+flb1.size());
		z = 0;
		vn.toElement(VTDNav.ROOT);
		if (vn.toElement(VTDNav.FIRST_CHILD)){
			 do{
			 	if (vn.toElement(VTDNav.FIRST_CHILD)){
					 do{
					 	if (vn.toElement(VTDNav.FIRST_CHILD)){
							 do{
							 	z++;
							    vn.sampleState(flb1); // level3
							 } while(vn.toElement(VTDNav.NEXT_SIBLING));
							 vn.toElement(VTDNav.PARENT);
						}
					 } while(vn.toElement(VTDNav.NEXT_SIBLING));
					 vn.toElement(VTDNav.PARENT);
				}
			 } while(vn.toElement(VTDNav.NEXT_SIBLING));
			 vn.toElement(VTDNav.PARENT);
		}
		//System.out.println("level3 occurance "+z);
		//System.out.println("flb2 size is :"+flb1.size());
		z = 0;
		vn.toElement(VTDNav.ROOT);
		if (vn.toElement(VTDNav.FIRST_CHILD)){
			 do{
			 	if (vn.toElement(VTDNav.FIRST_CHILD)){
					 do{
					 	if (vn.toElement(VTDNav.FIRST_CHILD)){
							 do{
							 	if (vn.toElement(VTDNav.FIRST_CHILD)){
									 do{
									 	z++;
									    vn.sampleState(flb1); // level4
									 } while(vn.toElement(VTDNav.NEXT_SIBLING));
									 vn.toElement(VTDNav.PARENT);
								}
							 } while(vn.toElement(VTDNav.NEXT_SIBLING));
							 vn.toElement(VTDNav.PARENT);
						}
					 } while(vn.toElement(VTDNav.NEXT_SIBLING));
					 vn.toElement(VTDNav.PARENT);
				}
			 } while(vn.toElement(VTDNav.NEXT_SIBLING));
			 vn.toElement(VTDNav.PARENT);
		}
		//System.out.println("level4 occurance "+z);
		//System.out.println("flb2 size is :"+flb1.size());
		z= 0;
		vn.toElement(VTDNav.ROOT);
		AutoPilot ap = new AutoPilot(vn);
		ap.selectElement("level1:level1");
		while(ap.iterate()){
			z++;
			//System.out.println("index "+vn.getCurrentIndex()+": "+vn.toString(vn.getCurrentIndex()));
			vn.sampleState(flb2);
		}
		//System.out.println("level1 occurance "+z);
		//System.out.println("flb2 size is :"+flb2.size());
		z = 0;
		vn.toElement(VTDNav.ROOT);
		ap.selectElement("level2:level2");
		while(ap.iterate()){
			z++;
			vn.sampleState(flb2);
		}
		//System.out.println("level2 occurance "+z);
		//System.out.println("flb2 size is :"+flb2.size());
		z = 0;
		vn.toElement(VTDNav.ROOT);
		ap.selectElement("level3:level3");
		while(ap.iterate()){
			z++;
			vn.sampleState(flb2);
		}
		//System.out.println("level3 occurance "+z);
		//System.out.println("flb2 size is :"+flb2.size());
		z = 0;
		vn.toElement(VTDNav.ROOT);
		ap.selectElement("level4:level4");
		while(ap.iterate()){
			z++;
			
			vn.sampleState(flb2);
		}
		//System.out.println("level4 occurance "+z);
		//System.out.println("flb2 size is :"+flb2.size());
		z = 0;
		if (flb1.size()!=flb2.size()){
			return false;
		}
		for (int i=0;i<flb1.size();i++){
		  if (flb1.intAt(i)!= flb2.intAt(i))
		  	return false;
		}
	}catch (ParseException e){
		System.out.println("ParserException: "+e);
		e.printStackTrace();
		return false;
	}catch (NavException e){
		System.out.println("NavException:"+e);
		return false;
	}
	catch (Exception e){
		e.printStackTrace();
		System.out.println("other exceptions");
		return false;
	}
		return true;		
	}
	
	public static void main(String[] args) {
		String fileName = "d://ximple-dev//testcases//AutoPilot//"+args[0];
	       if (test(fileName)) {
			System.out.println(fileName + " passed!");
		} else
			System.out.println(fileName + " failed!");

		if (test2(fileName)) {
			System.out.println(fileName + " passed!");
		} else
			System.out.println(fileName + " failed!");
	}
}
