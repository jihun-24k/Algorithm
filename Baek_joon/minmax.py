# 백준 10818번 최소, 최대
N = int(input())
array = list(map(int, input().split()))
array.sort()
print(array[0],array[-1])