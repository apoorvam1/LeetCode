1. Creating a result DataStructure inside the recursive call and updating it

Create the Data Structure \
Update is while making the recursive call \
Note: It is not in the call signature

ex: Adding all the TowerOfHanoi moves to the result LinkedList
```
private List<Move> hanoiMoves(int n, Position src, Position dest, Position aux) {
  if(n == 1) return new ArrayList(new Move(n, src, dest));
  
  List<Move> result = new LinkedList<>();
  result.addAll(hanoiMoves(n-1, src, aux, dest));
  result.add(new Move(n, src, dest));
  result.addAll(hanoiMoves(n-1, aux, dest, src));

  return result;
}
```
