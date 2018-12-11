// 入力フォームチェックを行います


	//日付かどうかの判断
  	//  value : 判定する文字列(yy-mm-dd)としたい
  	function isDate(value){
  		if(value.split('-').length<3) return false;
		//split()メソッド・・・文字列を複数の部分文字列に区切ることで文字列の配列に分割
		 var date = new Date(value.split('-')[0], value.split('-')[1] - 1, value.split('-')[2]);
		 if (value.split('-')[0] !== String(date.getFullYear()) ||
			value.split('-')[1] !== ('0' + (date.getMonth() +1)).slice(-2) ||
			value.split('-')[2] !== ('0' + date.getDate()).slice(-2))
		 	//ゼロパディング処理
		 {
		 return false;
		 } else {
		 return true;
		 }
	}

  	//数値かどうかの判断
  	function checkNum(value){
  		//数値:true それ以外(文字、記号)はfalse
  		result=false;

  		if(isFinite(value)){  //有限値はtrue
  			result =true;
  		}
  		return result;
  	}

  	// クリアボタン実行時に起動
  	$(function () {
    	$(".clear-button").on("click", function () {
        clearForm(this.form);
    	});

    function clearForm (form) {
        $(form)
            .find("input, select, textarea")
            .not(":button, :submit, :reset, :hidden")
            .val("")
            .prop("checked", false)
            .prop("selected", false);
        $(form).find(":radio").filter("[data-default]").prop("checked", true);
        $('.add').html("");
    	}
		});
  	//------------------------------------------------------------------

  	//submit押した瞬間に実行する
  	$(function(){
  		$('form').submit(function(){
  		//clearForm(this.form);

  		var errMsg ="";
  		var i = 0;  //初期値

  		//名前のチェック①
  		var value=$('input[name="guestName"]').val();
  		if(value.length<=0){
  			errMsg ="名前は必須です\n";
  			$('#add1').html(errMsg);
  			i++;
  		}
  		else{
  			$('#add1').html("");
  		}

  		//かなのチェック② //テキストボックス使用
  		var value=$('input[name="guestKana"]').val();
  		if(value.length<=0){
  			errMsg ="カナは必須です\n";
  			$('#add2').html(errMsg);
  			i++;
  		}
  		else if(!value.match(/^[ア-ンー]*$/)){
  			errMsg ="カナが正しく入力されていません\n";
  			$('#add2').html(errMsg);
  			i++;
  		}
  		else{
  			$('#add2').html("");
  		}

  		//パスワードのチェック③ //テキストボックス使用
  		var value=$('input[name="guestPass"]').val();
  		if(value.length <=0){
  			errMsg = "パスワードは必須です\n";
  			$('#add3').html(errMsg	);
  			i++;
  		}
  		else{ //正規表現
				if(!value.match(/^[a-z\d]{8,16}$/i)){   //でfalseの時
					errMsg = "パスワードではない値が入力されています\n";
					$('#add3').html(errMsg);
					i++;
				}
				else{
  				$('#add3').html("");
  			}
			}


  		//生年月日のチェック④ //テキストボックス使用
  		var value=$('input[name="guestBirthday"]').val();
  		if(value.length <=0){
  			errMsg = "生年月日は必須です\n";
  			$('#add4').html(errMsg);
  			i++;
  		}
  		else{
				if(!isDate(value)){   /!でfalseの時/
					errMsg = "日付ではない値が入力されています\n";
					$('#add4').html(errMsg);
					i++;
				}
				else{
  				$('#add4').html("");
  			}
			}


  		//電話番号のチェック⑤
  		var value=$('input[name="guestTel"]').val();
  		if(value.length<=0){
  			errMsg="電話番号は必須です";
  			$('#add5').html(errMsg);
  			i++;
  		}
  		else {
  			if(!checkNum(value)){
  				errMsg="文字が入力されています";
  				$('#add5').html(errMsg);
  				i++;
  			}
  			else{
  				$('#add5').html("");
  			}
  		}

  		//メールのチェック⑥
  		var value=$('input[name="guestMail"]').val();
  		if(value.length<=0){
  			errMsg ="メールアドレスは必須です";
  			$('#add6').html(errMsg);
  			i++;
  		}
  		else if(!value.match(/.+@.+\..+/)){
  			errMsg ="メールアドレスが正しく入力されていません\n";
  			$('#add6').html(errMsg);
  			i++;
  		}
  		else{
  			$('#add6').html("");
  		}


  		//趣味のチェック⑦
  		var value=$('input[name="guestAddress"]').val();
  		if(value.length<=0){
  			errMsg="住所は必須です\n";
  			$('#add7').html(errMsg);
  			i++;
  		}
  		else{
  			$('#add7').html("");
  		}

		//全てチェックされているかを判断⑧
		if(i>0){
			return false;
		}
		else{
			if(window.confirm('実行しますか？')){
				return true;
			}
			else{
				return false;
			}
		}

	}) 	//submit(function()
}) // $(function()