def solution(n, computers):
    answer = 0
    visited = [False] * n
    
    def dfs(idx):
        visited[idx] = True
        for i in range(n):
            if not visited[i] and computers[idx][i] == 1:
                dfs(i)
    for j in range(n):
        if not visited[j]:
            answer += 1
            dfs(j)

    return answer