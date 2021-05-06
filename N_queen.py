# 백준 9663번 N-Queen

N = int(input())

queen = [-1] * N
result = 0

def check_queen(col, row):
    for i in range(row):
        # 대각선
        if abs(queen[i] - queen[row]) == row - i or queen[i] == queen[row]:
            return True
    return False

def dfs(row):
    global result
    if row == N:
        result += 1
    else:
        for col in range(N):
            queen[row] = col
            if not (check_queen(col, row)):
                dfs(row + 1)
dfs(0)
print(result)