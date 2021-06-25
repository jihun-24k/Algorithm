# 백준 11505번 구간 곱 구하기
import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())
nums = [int(input()) for _ in range(N)]
abc = [map(int, input().split()) for _ in range(M + K)]
DIV = 1000000007

# 세그먼트 트리 생성
tree = [1] * 20

def init(node, start, end):
    if start == end:
        tree[node] = nums[start]
        return tree[node]
    else:
        tree[node] =  (init(node * 2, start, (start + end)//2) * init(node * 2 + 1, (start + end)//2 + 1, end)) % DIV
        return tree[node]

# 구간 곱 찾기
def find_mul(node, start, end, left, right):
    if left > end or right < start:
        return 1
    elif left <= start and end <= right:
        return tree[node]
    else:
        m1 = find_mul(node * 2, start, (start + end)//2, left, right)
        m2 = find_mul(node * 2 + 1, (start + end)//2 + 1, end, left, right)
        return (m1 * m2) % DIV

# 수 바꾸기
def update(node, start, end, index, diff, origin):
    if index < start or index > end:
        return
    if diff == 0:
        tree[node] = 0
    else:
        tree[node] = (tree[node] // origin) * diff    
    if start != end:
        update(node * 2, start, (start + end)//2, index, diff, origin)
        update(node * 2 + 1, (start + end)//2 + 1, end, index, diff, origin)

init(1, 0, N - 1)

for a, b, c in abc:
    if a == 1:
        b -= 1
        origin = nums[b]
        nums[b] = c
        if origin == 0:
            init(1, 0, N - 1)
        else:
            update(1, 0, N - 1, b, c , origin)
    elif a == 2:
        print(find_mul(1, 0, N - 1, b - 1, c - 1))
