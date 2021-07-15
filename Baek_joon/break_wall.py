# 백준 2206번 벽 부수고 이동하기
from collections import deque
n, m = map(int,input().split())
INF = int(1e9)

# 이동할 방향
dx = [1,-1,0,0]
dy = [0,0,-1,1]


graph = [list(map(int,input())) for _ in range(n)]
visit = [[[INF for _ in range(m)] for _ in range(n)] for _ in range(2)]

def bfs (x, y):
    queue = deque()
    queue.append([0,x,y])
    visit[0][x][y] = 1

    while queue:
        b, x, y = queue.popleft()
        # 동서남북 방향 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 만약 미로 범위 밖을 벗어나면
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if graph[nx][ny] == 0 and visit[b][nx][ny] == INF:
                visit[b][nx][ny] = visit[b][x][y] + 1
                queue.append([b, nx, ny])

            elif graph[nx][ny] == 1 and b == 0 and visit[1][nx][ny] == INF:
                visit[1][nx][ny] = visit[b][x][y] + 1
                queue.append([1, nx, ny])

    return(min(visit[0][n-1][m-1],visit[1][n-1][m-1]))

res = bfs(0, 0)
if res == INF:
    print(-1)
else:
    print(res)