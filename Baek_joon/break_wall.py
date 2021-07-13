# 백준 2206번 벽 부수고 이동하기
from collections import deque
n, m = map(int,input().split())

# 이동할 방향
dx = [1,-1,0,0]
dy = [0,0,-1,1]

graph = [list(map(int,input())) for _ in range(n)]
visit = [[False for _ in range(m)] for _ in range(n)]
dist = [[0 for _ in range(m)] for _ in range(n)]

def bfs (wall, x, y):
    queue = deque()
    queue.append([wall,x,y])
    visit[x][y] = True

    while queue:
        b, x, y = queue.popleft()
        # 동서남북 방향 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 만약 미로 범위 밖을 벗어나면
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if not visit[nx][ny]:
                visit[nx][ny] = True
                if b == 0:
                    if graph[nx][ny] == 1:
                        dist[nx][ny] = dist[x][y] + 1
                        queue.append([1, nx, ny])

                    if graph[nx][ny] == 0:
                        dist[nx][ny] = dist[x][y] + 1
                        queue.append([0, nx, ny])
                else:
                    if graph[nx][ny] == 0:
                        dist[nx][ny] = dist[x][y] + 1
                        queue.append([1, nx, ny])
    return(dist[n-1][m-1])

res = bfs(0, 0, 0)
if res == 0:
    print(-1)
else:
    print(dist[n-1][m-1] + 1)
