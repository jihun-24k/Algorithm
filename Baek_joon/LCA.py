# 백준 1437번 LCA
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
parent = [0] * (N + 1)  # 부모 노드 정보
d = [0] * (N + 1)       # 각 노드까지의 깊이(depth)
c = [0] * (N + 1)       # 노드 깊이를 계산했는지 여부
graph = [[] for _ in range(N + 1)] # 그래프 정보

for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 모든 노드의 깊이 정보를 dfs로 설정
def dfs(x, depth):
    c[x] = True
    d[x] = depth
    for y in graph[x]:
        # 이미 계산한 노드라면 skip
        if c[y]:
            continue
        parent[y] = x
        dfs(y, depth + 1)

# LCA 찾는 함수
def lca(a, b):
    # 1.두 노드의 깊이를 맞춘다
    while d[a] != d[b]:
        if d[a] > d[b]:
            a = parent[a]
        else:
            b = parent[b]
    # 2.두 노드의 같은 부모를 찾는다
    while a != b:
        a = parent[a]
        b = parent[b]
    return a

dfs(1, 0)

M = int(input())
for i in range(M):
    a, b = map(int, input().split())
    print(lca(a, b))