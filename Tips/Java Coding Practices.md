1. Declaring a Objects in Java. Why are collections usually declared as Interface obj = new Class()? For ex, when should
a linked list be declared as List list = new LinkedList<>(); and when should be declared as LinkedList list = new LinkedList().

The advantage of using  List myList = new ArrayList(); is to have polymorphic behaviour with respect to methods.
Say, for example, you can have a method which takes arguments of type List,

someMethod(List lst)
{
   lst.doSomething();
   //do somethng else.....
}
In this method lst can be of type Linked List, ArrayList or CopyOnWriteArrayList.

LinkedList<...> items = new LinkedList<...>();
is perfectly correct if you know that items will depend on methods of LinkedList<T> 
that are not captured in the List<T> interface.
