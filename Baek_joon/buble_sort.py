# 백준 1517번 버블 소트
import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
swap = 0

def merge_sort(low, high):
    global swap
    if high - low < 2:
        return
    mid = (low + high) // 2

    merge_sort(low, mid)
    merge_sort(mid,high)

    temp = []
    l, h = low, mid
    cnt = 0

    while l < mid and h < high:
        if arr[l] <= arr[h]:
            temp.append(arr[l])
            l += 1
            swap += cnt

        else:
            temp.append(arr[h])
            h += 1
            cnt += 1

    while l < mid:
        temp.append(arr[l])
        l += 1
        swap += cnt

    while h < high:
        temp.append(arr[h])
        h += 1

    for i in range(low, high):
        arr[i] = temp[i - low]

merge_sort(0, N)
print(swap)