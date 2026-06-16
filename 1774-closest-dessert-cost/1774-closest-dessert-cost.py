class Solution:
    def closestCost(self, baseCosts: List[int], toppingCosts: List[int], target: int) -> int:
        best = float('inf')
        def withToppings(base_cost: int, t_index:int):
            nonlocal best
            if t_index == len(toppingCosts):
                diff = abs(target-base_cost)
                best_diff = abs(target-best)
                if diff <= best_diff:
                    if best_diff == diff:
                        if base_cost < best:
                            best = base_cost
                    else:
                        best = base_cost
                return
            #0
            withToppings(base_cost, t_index+1)
            #1
            base_cost += toppingCosts[t_index]
            withToppings(base_cost, t_index+1)
            #2
            base_cost += toppingCosts[t_index]
            withToppings(base_cost, t_index+1)
        for base in baseCosts:
            withToppings(base, 0)
        return best

        