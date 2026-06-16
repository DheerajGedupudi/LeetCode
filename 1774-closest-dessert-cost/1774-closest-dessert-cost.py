class Solution:
    def closestCost(self, baseCosts: List[int], toppingCosts: List[int], target: int) -> int:
        best = float('inf')
        print(best)
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
            costs = []
            #0
            costs.append(base_cost)
            #1
            costs.append(base_cost + toppingCosts[t_index])
            #2
            costs.append(base_cost + (toppingCosts[t_index]*2))
            for c in costs:
                withToppings(c, t_index+1)
        for base in baseCosts:
            withToppings(base, 0)
        return best

        