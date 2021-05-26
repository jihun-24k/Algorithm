# 백준 1987번 알파벳

R, C = map(int, input().split())
board = [list(map(lambda x: ord(x)-65, input())) for _ in range(R)] # 아스키 코드로 바꿔줌 
done = [False]*26  # 알파벳 26개만큼 배열설정 
done[board[0][0]] = True

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y, cnt):
    global result
    result = max(result, cnt)

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0<= nx < R) and (0<= ny < C) and not done[board[nx][ny]]:
            done[board[nx][ny]] = True
            dfs(nx, ny, cnt + 1)
            done[board[nx][ny]] = False

result = 1
dfs(0, 0, result)
print(result)