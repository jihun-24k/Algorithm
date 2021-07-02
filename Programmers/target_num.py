def solution(numbers, target):
    answer = 0
    def dfs(n, all):
        if n == len(numbers):
            if all == target:
                return 1
            else:
                return 0
        else:
            return dfs(n + 1, all + numbers[n]) + dfs(n + 1, all - numbers[n])
    answer += dfs(0, 0)
    return answer