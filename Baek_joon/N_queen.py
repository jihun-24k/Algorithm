# 백준 9663번 N-Queen

def check_queen(queen, col):
    n = len(queen)
    for i in range(n):
        # 대각선
        if abs(queen[i] - col) == abs(n - i):
            return False
    return True

def dfs(queen, row):
    if row == N:
        result[0] += 1
    else:
        for col in range(N):
            if check_queen(queen, col) and not visited[col]:
                visited[col] = True
                dfs(queen + [col] ,row + 1)
                visited[col] = False

N = int(input())
visited = [False] * N
result = [0]
dfs([], 0)
print(*result)