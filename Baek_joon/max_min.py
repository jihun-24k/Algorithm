# 백준 2357번 최솟값과 최댓값
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = [int(input()) for _ in range(N)]
a_b = [list(map(int, input().split())) for _ in range(M)]

for a, b in a_b:
    print(min(nums[a - 1 : b]), max(nums[ a - 1 : b]))
