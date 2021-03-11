# 백준 2263번 트리의 순회(골드)
import sys
input = sys.stdin.readline

class Node:
    def __init__(self, data, left_node, right_node):
        self.data = data
        self.left_node = left_node
        self.right_node = right_node

def colabo_order ()

# 전위 순회 (Preorder Traversal)
def pre_order (node):
    print(node.data, end='')
    if node.left_node != '.':
        pre_order(tree[node.left_node])
    if node.right_node != '.':
        pre_order(tree[node.right_node])

n = int(input())
in_order = []
post_order = []
tree = {}

for i in range(n):
    data, left_node, right_node = map(str,input().split())
    tree[data] = Node(data, left_node, right_node)

pre_order(tree['A'])
print()
in_order(tree['A'])
print()
post_order(tree['A'])