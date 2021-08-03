package main;

import java.util.*;
public class MyClass{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        OttPlatforms[] ott = new OttPlatforms[4];
        for(int i=0;i<4;i++){
            String id = sc.nextLine();
      String name = sc.nextLine();
      String type = sc.nextLine();
      String price = sc.nextLine();
      ott[i] = new OttPlatforms(Integer.parseInt(id), name,type,Double.parseDouble(price));
        }
        String in1 = sc.nextLine();
        String in2 = sc.nextLine();
        int res1 = findAvgSubsPriceByType(ott,in1);
        if(res1>0){
      System.out.println(res1);
  }
  else{
      System.out.println("There are no such otts");
  }
  
  OttPlatforms[] res2 =searchOttBysubsType(ott,in2);
  
  if(res2 == null){
      System.out.println("There are no otts with given type");
  }
  else{
     for(int i =0;i<res2.length;i++){
          System.out.println(res2[i].id);
      }
  }
     }
     
     public static int findAvgSubsPriceByType(OttPlatforms[] o, String str){
         int avg=0;
         int count =0;
         double d = 0.0;
         for(int i =0;i<4;i++){
             if(o[i].type.equalsIgnoreCase(str)){
                 d = d + o[i].price;
                 count++;
             }
         }
         if(count==0)
        	 return 0;
         else {
         avg = (int)d/count;
         return avg;
         }
     }
     
     public static OttPlatforms[] searchOttBysubsType(OttPlatforms[] o,String str){
         OttPlatforms[] sNew = new OttPlatforms[0];
         int j=0;
         for(int i =0;i<4;i++){
      if(o[i].type.equalsIgnoreCase(str)){
    	  
    	  sNew = Arrays.copyOf(sNew,sNew.length+1);
          sNew[sNew.length-1] = o[i];
          j++;
      }
  }
  
  for(int i=0;i<j-1;i++){
      for(int m = i+1;m<j;m++){
          if((int)sNew[i].id > (int)sNew[m].id){
              OttPlatforms temp = sNew[i];
              sNew[i] = sNew[m];
              sNew[m] = temp;
          }
      }
  }
  
   if(j==0){
      return null;
  }
  else{
      return sNew;
  }
  
     }
}


class OttPlatforms{
    public int id;
    public String name;
    public String type;
    public double price;
    public OttPlatforms(int id,String name,String type,Double price){
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
}