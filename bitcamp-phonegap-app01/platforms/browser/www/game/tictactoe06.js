var human = 'X',
    computer = 'O',
    cells = $('.cell'),
    count = 0,
    isCompleted = false;

$('#cell-box').on('complete', (e, result) => {
    setTimeout(() => {
    if ( result == 1) alert("인강 승!");
    else if ( result == -1) alert("컴퓨터 승!");
    }, 500)
});

$('.cell').click((e) => {
    if (isCompleted) return;
    
    console.log($(e.target).attr('data-pos'));
    $(e.target).text(human);
    count++;
    
    var result = computeGame();
    if (result != 0) {
        $('#cell-box').trigger('complete', [result]);
        isCompleted = true;
    }
    
    if (isCompleted) return;
    
    // 타이머를 가동하여 1초 우에 컴퓨터가 표시하게 한다.
    setTimeout(() => {
        while (true){
            var no = Math.floor(Math.random() * 9);
            if (!isCellChecked(no)) {
                checkCell(no, 'computer');
                break;
            }
        }
        
        var result = computeGame(); 
        if (result != 0) {
            $('#cell-box').trigger('complete', [result]);
            isCompleted = true;
        } else if (count == 5) {
            alert("비겼다!");
        }

    }, 1000);
});

$('#new-game').click((e) => {
    console.log('new game!');
});

function isCellChecked(no) {
    return cells[no].innerHTML != "" ? true : false;
}

function checkCell(no, gamer) {
    cells[no].innerHTML = 
        (gamer == 'computer') ? computer : human;
}

function computeGame() {
    for (var row = 0; row < 9; row += 3) {
        var countHuman = 0;
        var countComputer = 0;
        for (var i = row; i < (row + 3); i++) {
            if (cells[i].innerHTML == human) countHuman++;
            else if (cells[i].innerHTML == computer) countComputer++;
        }
        if (countHuman == 3) return 1;
        else if (countComputer == 3) return -1;
        console.log(countHuman, countComputer);
    }
    
    
    for (var col = 0; col < 3; col++) {
        var countHuman = 0;
        var countComputer = 0;
        for (var i = col; i <= (col + 6); i += 3) {
            if (cells[i].innerHTML == human) countHuman++;
            else if (cells[i].innerHTML == computer) countComputer++;
        }
        if (countHuman == 3) return 1;
        else if (countComputer == 3) return -1;
        console.log(countHuman, countComputer);
    }
    
    var countHuman = 0;
    var countComputer = 0;
    for (var i = 0; i <= 8; i += 4) {
        if (cells[i].innerHTML == human) countHuman++;
        else if (cells[i].innerHTML == computer) countComputer++;
    }
    if (countHuman == 3) return 1;
    else if (countComputer == 3) return -1;
    console.log(countHuman, countComputer);
        
    var countHuman = 0;
    var countComputer = 0;
    for (var i = 0; i < 6; i += 2) {
        if (cells[i].innerHTML == human) countHuman++;
        else if (cells[i].innerHTML == computer) countComputer++;
    }
    if (countHuman == 3) return 1;
    else if (countComputer == 3) return -1;
    console.log(countHuman, countComputer);
    
    return 0;
    
}














