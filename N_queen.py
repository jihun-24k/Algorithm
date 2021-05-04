# 백준 9663번 N-queen

N = int(input())

col = [0] * (N + 1)
result = 0

def check_queen(row, col):
    for i in range(1, row):
        if (abs(col[i] - col[row]) == row - i or col[i] == col[row]):
            return False
    return True

def dfs(row, col):
    global result
    if check_queen(row, col):
        if row == N:
            result += 1
        else:
            for k in range(1, N + 1):
                col[row + 1] = k
                dfs(row + 1, col)
dfs(0, col)
print(result)