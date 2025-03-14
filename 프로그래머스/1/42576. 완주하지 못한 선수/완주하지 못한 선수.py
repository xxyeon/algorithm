def solution(participant, completion):
    answer = ''
    participant_dict = {}
    completion_dict = {}
    for name in participant:
        if name in participant_dict:
            participant_dict[name] += 1
        else:
            participant_dict[name] = 1
    for name in completion:
        if name in completion_dict:
            completion_dict[name] += 1
        else:
            completion_dict[name] = 1
    
    for name in participant:
        if name not in completion_dict:
            answer = name
        elif completion_dict[name] != participant_dict[name]:
            answer = name
        
                
    return answer