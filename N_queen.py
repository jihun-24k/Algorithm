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
<<<<<<< HEAD
    if check_queen(row, col):
        if row == N:
            result += 1
        else:
            for k in range(1, N + 1):
                col[row + 1] = k
                dfs(row + 1, col)
                
dfs(0, col)
=======
    if row == N:
        result += 1
    else:
        for col in range(N):
            queen[row] = col
            if not (check_queen(col, row)):
                dfs(row + 1)
dfs(0)
>>>>>>> 14b3cfc38d8d918cf45992a49c5fd0008acb3204
print(result)