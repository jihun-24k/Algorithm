# 백준 15650번 N과 M (2)

N, M = map(int,input().split())

visited = [False] * (N + 1)
arr = [0] * M
def dfs(cnt):
    # 해당하는 수열을 찾았을 때
    if cnt == M:
        # 오름차순
        for i in range(M - 1):
            if arr[i] > arr[i+1]:
                return
        print(" ".join(map(str, arr)))
    else:
        for i in range(1, N + 1):
            if not visited[i]:
                visited[i] = True
                arr[cnt] = i
                dfs(cnt + 1)
                visited[i] = False
dfs(0)