Question:
https://leetcode.com/problems/design-an-atm-machine/description/

Solution
```python
class ATM:

    def __init__(self):
        # need a datatype to store denomination and their count
        # 20: count
        # 50: count ...
        # or array where we know which index is for which note
        self.bank_money = [0] * 5
        self.denom = [20, 50, 100, 200, 500]
        

    # [0, 0, 1, 2, 1]
    def deposit(self, banknotesCount: List[int]) -> None:
        for i, bn in enumerate(banknotesCount):
            self.bank_money[i] += bn

    def withdraw(self, amount: int) -> List[int]:
        res = [0] * 5
        
        for i in range(4, -1, -1):
            curDenom = self.denom[i]
            denomCount = self.bank_money[i]
            need = min(denomCount, amount // curDenom)
            res[i] = need
            amount -= (need * curDenom)
        if amount == 0:
            self.deposit(-x for x in res)
            return res
        else:
            return [-1]
```
