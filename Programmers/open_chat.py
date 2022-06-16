# 카카오 기출문제
re = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
def solution(record):
    answer = []
    db = {}
    for r in record:
        data = r.split()
        if len(data) == 3:
            db[data[1]] = data[2]
        
    for k in record:
        data = k.split()
        if data[0] == 'Enter':
            answer.append(db[data[1]] + '님이 들어왔습니다.')
        elif data[0] == 'Leave':
            answer.append(db[data[1]] + '님이 나갔습니다.')
    
    return answer

print(solution(re))

string = 'abc'
for s in range(0, len(string)):
    string[s] = 'a'
print(string)