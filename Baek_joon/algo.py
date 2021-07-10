# 백준 1261번 알고스팟
from heapq import heappush, heappop
# 가로는 m 세로는 n
m, n = map(int,input().split())

# 이동할 방향
dx = [1,-1,0,0]
dy = [0,0,-1,1]

graph = [list(map(int,input())) for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]

def bfs (block ,x, y):
    global result
    h = []
    heappush(h, (block, x, y))
    visited[y][x] = True

    while h:
        b, x, y = heappop(h)
        if x == m - 1 and y == n - 1:
            return b
        # 동서남북 방향 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 만약 미로 범위 밖을 벗어나면
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue
            if not visited[ny][nx]:
                # 그냥 빈 방일 때
                if graph[ny][nx] == 0:
                    visited[ny][nx] = True
                    heappush(h,(b, nx, ny))
                # 벽일때
                else:
                    visited[ny][nx] = True
                    heappush(h,(b + 1,nx,ny))

print(bfs(0, 0, 0))