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
tree1 = [0] * 30
tree2 = [0] * 30

def init(node, start, end):
    if start == end:
        tree1[node] = nums[start]
        tree2[node] = nums[start]
    else:
        init(node*2, start, (start+end)//2)
        init(node*2+1, (start+end)//2+1, end)
        if nums[start] < nums[end]:
            tree1[node] = nums[start]
            tree2[node] = nums[end]
        else:
            tree1[node] = nums[end]
            tree2[node] = nums[start]

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
    m1 = find_max(node * 2, start, (start + end)//2, left, right)
    m2 = find_max(node * 2 + 1, (start+end)//2 + 1, end, left, right)

    if m1 == -1:
        return m2
    elif m2 == -1:
        return m1
    else:
        return max(m1, m2)

init(1, 0, N-1)
print(nums)
print(tree1)
print(tree2)

for a, b in a_b:
    min_v = find_min(1, 0, N - 1, a - 1, b - 1)
    max_v = find_max(1, 0, N - 1, a - 1, b - 1)
    print(min_v, max_v)