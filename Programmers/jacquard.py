def multiple_sets(string):
    lists = []
    for i in range(len(string) - 1):
        if ord(string[i]) < 65 or ord(string[i]) > 90:
            continue
        elif ord(string[i + 1]) < 65 or ord(string[i + 1]) > 90:
            continue
        lists.append(string[i:i+2])
    return lists

def jacquard(x, y):
    if x == 0 or y == 0:
        return 65536
    return int(x / y * 65536)
        

def solution(str1, str2):
    list1 = multiple_sets(str1.upper())
    list2 = multiple_sets(str2.upper())
  
    intersection = list(set(list1) & set(list2))
    union = list(set(list1)|set(list2))
    gyo = 0
    hap = 0
    for data in intersection:
        a = list1.count(data)
        b = list2.count(data)
        if a > b:
            gyo += b - 1
            hap += a - 1
        else:
            gyo += a - 1
            hap += b - 1
    gyo += len(intersection)
    hap += len(union)
    
    return jacquard(gyo, hap)

print(solution('FRANCE', 'franch'))