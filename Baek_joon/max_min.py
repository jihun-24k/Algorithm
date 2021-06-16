# 백준 2357번 최솟값과 최댓값
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

N, M = map(int, input().split())
nums = [int(input()) for _ in range(N)]
a_b = [list(map(int, input().split())) for _ in range(M)]

# 세그먼트 트리
# tree1 = 최소값을 담은 트리
# tree2 = 최댓값을 담은 트리
tree1 = [0] * 3000000
tree2 = [0] * 3000000

def init_min(node, start, end):
    if start == end:
        tree1[node] = nums[start]
        return tree1[node]
    else:
        tree1[node] = min(init_min(node*2, start, (start+end)//2), init_min(node*2+1, (start+end)//2+1, end))
        return tree1[node]

def init_max(node, start, end):
    if start == end:
        tree2[node] = nums[start]
        return tree2[node]
    else:
        tree2[node] = max(init_max(node*2, start, (start+end)//2), init_max(node*2+1, (start+end)//2+1, end))
        return tree2[node]

def find_min(node, start, end, left, right):
    if left > end or right < start:
        return -1
    if left <= start and end <= right:
        return tree1[node]
    m1 = find_min(node * 2, start, (start + end)//2, left, right)
    m2 = find_min(node * 2 + 1, (start+end)//2+1, end, left, right)
    
    if m1 == -1:
        return m2
    elif m2 == -1:
        return m1
    else:
        return min(m1, m2)

def find_max(node, start, end, left, right):
    if left > end or right < start:
        return -1
    if left <= start and end <= right:
        return tree2[node]
    n1 = find_max(node * 2, start, (start + end)//2, left, right)
    n2 = find_max(node * 2 + 1, (start+end)//2 + 1, end, left, right)

    if n1 == -1:
        return n2
    elif n2 == -1:
        return n1
    else:
        return max(n1, n2)

init_min(1, 0, N-1)
init_max(1, 0, N-1)

for a, b in a_b:
    min_v = find_min(1, 0, N - 1, a - 1, b - 1)
    max_v = find_max(1, 0, N - 1, a - 1, b - 1)
    print(min_v, max_v)