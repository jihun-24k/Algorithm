from collections import deque
n, m = map(int,input().split())

# 이동할 방향
dx = [1,-1,0,0]
dy = [0,0,-1,1]

# 그래프 입력 받기, 벽 부수는걸 확인하기 위한 2차원 리스트도 만들기
graph = []
boom_wall = []
for i in range(m):
    graph.append(list(map(int,input())))
    boom_wall.append(graph[i])

visited = [[False]*n for _ in range(m)]

def bfs (x, y):
    queue = deque()
    queue.append((x,y))

    while queue:
        visited[x][y] = True
        x, y = queue.popleft()
        # 동서남북 방향 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 만약 미로 범위 밖을 벗어나면
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            # 그냥 빈 방일 때
            if graph[nx][ny] == 0 and not visited[nx][ny]:
                boom_wall[nx][ny] = boom_wall[x][y]
                queue.append((nx,ny))

            # 방문한 길일 땐
            if graph[nx][ny] == 0 and visited[nx][ny]: 
                boom_wall[nx][ny] = boom_wall[x][y]

            # 만약 처음 벽을 만났을 때
            if graph[nx][ny] == 1 and not visited[nx][ny]:
                boom_wall[nx][ny] = boom_wall[x][y] + 1
                queue.append((nx,ny))

            # 이미 부쉈던 벽이라면
            if graph[nx][ny] == 1 and visited[nx][ny]:
                boom_wall[nx][ny] = min(boom_wall[x][y] + 1, boom_wall[nx][ny])

    return(boom_wall[n-1][m-1])

print(bfs(0, 0))