# 백준 1167번 트리의 지름 (골드 3)
import sys
from collections import deque
input = sys.stdin.readline

class Node:
    def __init__(self, data, left, right):
        self.data = data
        self.left = left
        self.right = right

N = int(input())
tree = [[] for _ in range(N+1)]

for i in range(N):
    data = list(map(int,input().split()))[:-1]
    for i in range(1,len(data),2):
        tree[data[0]].append([data[i],data[i+1]])

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