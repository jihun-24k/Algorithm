# 백준 9663번 N-Queen

N = int(input())

visited = [False] * N
result = [0]

def check_queen(queen, col):
    n = len(queen)
    for i in range(n):
        # 대각선
        if abs(queen[i] - col) == abs(n - i):
            return True
    return False

def dfs(queen, row):
    if row == N:
        result[0] += 1
    else:
        for col in range(N):
            if not (check_queen(queen, col)) and not visited[col]:
                visited[col] = True
                dfs(queen + [col] ,row + 1)
                visited[col] = False
dfs([], 0)
print(*result)