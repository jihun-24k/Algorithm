n, m = map(int,input().split())

friends = [[]*i for i in range(n)]

for _ in range(m):
    f1, f2 = map(int,input().split())
    friends[f1].append(f2)
    friends[f2].append(f1)

# 방문됐는지 
visited = [False]*n
depth = [0] * n

def dfs (graph, v, visited, depth):
    visited[v] = True
    depth[v] += 1

    for i in graph[v]:
        if not visited[i]:
            depth[i] = depth[v]
            dfs(graph,i,visited,depth)

for i in range(n):
    dfs(friends, i, visited, depth)
    if max(depth) >= 5:
        print(1)
        break

if max(depth) < 5:
    print(0)