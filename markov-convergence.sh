multipler=1000
trials=2048008000
result=$(java-introcs Transition < data/tiny.txt | java-introcs RandomSurfer $trials)
echo $trials
echo $result
echo "---------------------------"
while : ;do
    trials=$(echo "$trials + $multipler" | bc)
    result_old=$result
    result=$(java-introcs Transition < data/tiny.txt | java-introcs RandomSurfer $trials)
    echo $trials
    echo $result
    if [[ $result_old != $result ]];then
        break
    fi
    echo "---------------------------"
done






