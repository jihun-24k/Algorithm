# 백준 13023번 ABCDE

n, m = map(int,input().split())

friends = [[]*i for i in range(n)]

for _ in range(m):
    f1, f2 = map(int,input().split())
    friends[f1].append(f2)
    friends[f2].append(f1)

# 방문됐는지 
visited = [False]*n
result = 0

def dfs (v, depth):
    visited[v] = True
    global result
    # ABCDE의 친구 관계가 있다면
    if depth >= 4:
        result = 1
    else:
        # v 시작점부터 깊이를 탐색
        for i in friends[v]:
            if not visited[i]:
                dfs(i,depth+1)
        # 만약 마지막 정점이라면 False로 초기화
        visited[v] = False

for i in range(n):
    dfs(i, 0)
    if result:
        break

print(result)