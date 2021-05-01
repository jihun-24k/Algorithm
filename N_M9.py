# 백준 15663번 N과 M (9)

N, M = map(int,input().split())

visited = [False] * (N + 1)
input_num = sorted(list(map(int, input().split())))
arr = [0] * M

def dfs(cnt):
    # 해당하는 수열을 찾았을 때
    if cnt == M:
        print(" ".join(map(str, arr)))
    else:
        before = -1
        for i in range(1, N + 1):
            if not visited[i] and before != input_num[i-1]:
                before = input_num[i-1]
                visited[i] = True
                arr[cnt] = input_num[i-1]
                dfs(cnt + 1)
                visited[i] = False
dfs(0)