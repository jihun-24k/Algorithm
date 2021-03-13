# 백준 2263번 트리의 순회(골드)
import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
in_order = list(map(int, input().split()))
post_order = list(map(int, input().split()))

# 방문 확인
in_visited = [False]*len(in_order)
post_visited = [False]*len(post_order)

# 후위 순회의 제일 마지막 노드는 루트 노드다
queue = deque()
queue.append(post_order[-1])

while queue:
    root = queue.popleft()

    i_idx = in_order.index(root)
    p_idx = post_order.index(root)

    in_visited[i_idx] = True
    post_visited[p_idx] = True
    print(root, end=' ')

    # 왼쪽 서브 트리
    if i_idx != 0 and in_visited[i_idx-1] != True:
        queue.append(in_order[i_idx-1])
    # 오른쪽 서브 트리
    if p_idx !=0 and post_visited[p_idx-1] != True:
        queue.append(post_order[p_idx-1])
