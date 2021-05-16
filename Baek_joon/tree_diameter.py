# 백준 1967번 트리의 지름 (골4)
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())

tree = [[] for _ in range(N+1)]
for _ in range(N-1):
    n1, n2, weight = map(int,input().split())
    tree[n1].append([n2, weight])
    tree[n2].append([n1, weight])


def bfs(root):
    queue = deque()
    queue.append([root, 0])
    visited = [False] * (N+1)
    
    max_value = 0
    max_node = 0

    while queue:
        node, weight = queue.popleft()
        visited[node] = True

        for n, w in tree[node]:

            if not visited[n]:
                visited[n] = True
                queue.append([n, w + weight])

                if w + weight > max_value:
                    max_node = n
                    max_value = w + weight

    return max_node, max_value

print(bfs(bfs(1)[0])[1])