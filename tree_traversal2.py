# 백준 2263번 트리의 순회(골드)
import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
in_order = list(map(int, input().split()))
post_order = list(map(int, input().split()))

# 각각의 방문 리스트를 생성
in_visited = [False]*len(in_order)
post_visited = [False]*len(post_order)

# 트리 생성
class Node:
    def __init__(self, data, left_node, right_node):
        self.data = data
        self.left_node = left_node
        self.right_node = right_node

# 트리 입력
tree = {}

for i in range(n):

    # 후위순회의 제일 마지막 노드가 루트 노드이다.
    queue = deque(post_order[-1])

    while queue:
        v = queue.popleft()
        # 루트의 중위,후위 인덱스
        i_idx = in_order.index(v)
        p_idx = post_order.index(v)

        in_visited[i_idx] = True
        post_visited[p_idx] = True

        if i_idx ==0 or p_idx ==0:
            

    data, left_node, right_node = map(int,input().split())
    tree[data] = Node(data, left_node, right_node)

# 전위 순회 (Preorder Traversal)
def pre_order (node):
    print(node.data, end='')
    if node.left_node != '.':
        pre_order(tree[node.left_node])
    if node.right_node != '.':
        pre_order(tree[node.right_node])
