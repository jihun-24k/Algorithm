# 백준 2263번 트리의 순회(골드)
import sys
sys.setrecursionlimit(10**9)

n = int(input())
in_order = list(map(int, input().split()))
post_order = list(map(int, input().split()))

pos = [0]*(n+1)
for i in range(n): 
    pos[in_order[i]] = i

def pre_order(i_start, i_end, p_start, p_end):

    if p_start <= p_end:
        root = post_order[p_end] 
        print(root, end = ' ')

        left = pos[root] - i_start
        right = i_end - pos[root]

        pre_order(i_start, i_end + left -1 , p_start, p_end + left -1)
        pre_order(i_end-right+1, i_end, p_end-right, p_end-1)

pre_order(0,n-1,0,n-1)