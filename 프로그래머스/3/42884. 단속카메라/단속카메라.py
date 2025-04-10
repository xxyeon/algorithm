def solution(routes):
    answer = 0
    routes.sort(key = lambda x:x[1])
    install = []
    for start, end in routes:
        if install:
            if install[-1] >= start:
                continue
            else:
                install.append(end)

        else: #아직 카메라가 설치되지 않았다면
            install.append(end)

 
    return len(install)