class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        dirs = ((0,1), (1,0), (-1,0), (0,-1))
        visited = [[False] * len(grid[0]) for _ in range(len(grid))]

        def visit_land(x, y):
            q = deque()
            q.append([x,y])
            visited[x][y] = True
            while q:
                curr = q.popleft()
                for dir in dirs:
                    r = curr[0]+dir[0]
                    c = curr[1]+dir[1]
                    if r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and not visited[r][c] and grid[r][c] == '1':
                        q.append([r,c])
                        visited[r][c] = True

        for i, row in enumerate(grid):
            for j, cell in enumerate(row):
                if cell == '1':
                    if not visited[i][j]:
                        visit_land(i, j)
                        count += 1
        return count