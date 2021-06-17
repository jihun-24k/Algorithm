# 백준 2042번 구간 합 구하기
import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())
nums = [int(input()) for _ in range(N)]
abc = [map(int, input().split()) for _ in range(M + K)]

# 세그먼트 트리 생성
tree = [0] * 3000000

def init(node, start, end):
    if start == end:
        tree[node] = nums[start]
        return tree[node]
    else:
        tree[node] =  init(node * 2, start, (start + end)//2) + init(node * 2 + 1, (start + end)//2 + 1, end)
        return tree[node]
# 구간 합 찾기
def find_sum(node, start, end, left, right):
    if left > end or right < start:
        return 0
    elif left <= start and end <= right:
        return tree[node]
    else:
        m1 = find_sum(node * 2, start, (start + end)//2, left, right)
        m2 = find_sum(node * 2 + 1, (start + end)//2 + 1, end, left, right)
        return m1 + m2
# 수 바꾸기
def update(node, start, end, index, diff):
    if index < start or index > end:
        return
    tree[node] = tree[node] + diff     
    if start != end:
        update(node * 2, start, (start + end)//2, index, diff)
        update(node * 2 + 1, (start + end)//2 + 1, end, index, diff)

init(1, 0, N - 1)

for a, b, c in abc:
    if a == 1:
        b -= 1
        diff = c - nums[b]
        nums[b] = c
        update(1, 0, N - 1, b, diff)
    elif a == 2:
        print(find_sum(1, 0, N - 1, b - 1, c - 1))