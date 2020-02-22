public class MySet extends LinkedList{

 //add method add()without duplication
 public void add(int item){
  if(!isFound(item))
   addLast(item);
 }
 
 public MySet union(MySet set){
 
 MySet union = new MySet();
 Node p = this.head;
 while(p != null)
  {
   union.add(p.getItem());
   p = p.getNext();
  }
 //proceed to argument object
 Node p2 = set.head;
 while(p2 != null){
  union.add(p2.getItem());
  p2 = p2.getNext();
 }
 return union;
 }

 public MySet intersection(MySet set){
 MySet intersection = new MySet();
 Node p = this.head;
 Node p2 = set.head;
 while (p!=null){
   while (p2!=null){
      if (p.getItem()==p2.getItem()){
         intersection.add(p2.getItem());
      }
      p2 = p2.getNext();
  }
  p = p.getNext();
  p2 = set.head;
 }
 return intersection;
 }
 public MySet difference(MySet set){
   MySet difference = new MySet();
   Node p = this.head;
   Node p2 = set.head;
   while(p!=null){
      while(p2!=null){
         if (!set.isFound(p.getItem()))
         difference.add(p.getItem());
         p2 = p2.getNext();
      }
      p = p.getNext();
      p2 = set.head;
   }
   return difference;
 }
 public boolean isSubset(MySet set){
      Node p2 = head;
      boolean found = true;
      while (p2!=null){
         
            if(!set.isFound(p2.getItem())){
             found = false;
             break;
             }
             p2 = p2.getNext();
      }
      return found;
 } 
 public int cardinality(){
      return getLength();
    }

 public static void main(String []args){
  MySet setA = new MySet();
  MySet setB  = new MySet();
  setA.add(5);
  setA.add(6);
  setA.add(1);
  setA.add(2);
  setA.add(3);
  setB.add(7);
  setB.add(5);
  setB.add(9);
  setB.add(8);
  setB.add(6);
  setB.add(2);
  setB.add(4);
  setB.add(1);
  setB.add(3);
  setB.add(10);        
  System.out.println("set A contains : " + setA);
  System.out.println("set B contains : " + setB);
  System.out.println("A.union(B) : " + (setA.union(setB)));
  System.out.println("A.intersection(B) : " + (setA.intersection(setB)));
  System.out.println("A.difference(B) : "+(setA.difference(setB)));
  System.out.println("B.difference(A) : "+(setB.difference(setA)));   
  System.out.println("A.isSubset(B) : "+(setA.isSubset(setB)));
  System.out.println("B.isSubset(A) : "+(setB.isSubset(setA)));
  System.out.println("Set A cardinality : "+setA.cardinality());
  System.out.println("Set B cardinality : "+setB.cardinality());
 }

}