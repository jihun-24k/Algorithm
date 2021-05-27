# 백준 2239번 스도쿠
is_end = False
sudoku = [list(map(int, input())) for _ in range(9)]
zeros = [[i, j] for i in range(9) for j in range(9) if sudoku[i][j] == 0]

def is_promising(x, y):
    promising = [True] * 9
    for i in range(9):
        # 가로 확인
        if sudoku[x][i] != 0:
            promising[sudoku[x][i] - 1] = False
        # 세로 확인
        if sudoku[i][y] != 0:
            promising[sudoku[i][y] - 1] = False
    # 사각형 확인
    x = x//3
    y = y//3
    for k in range(x * 3, (x+1) * 3):
        for l in range(y * 3, (y+1) * 3):
            if sudoku[k][l] != 0:
                promising[sudoku[k][l] - 1] = False
    return promising


def dfs(cnt):
    global is_end
    if is_end:
        return
    elif cnt == len(zeros):
        for row in sudoku:
            for n in range(9):
                if n != 8:
                    print(row[n], end = '')
                else:
                    print(row[n])
        is_end = True
        return
    else:
        x, y = zeros[cnt]
        valid = is_promising(x, y)
        for num in range(9):
            if valid[num]:
                sudoku[x][y] = num + 1
                dfs(cnt + 1)
                sudoku[x][y] = 0
dfs(0)