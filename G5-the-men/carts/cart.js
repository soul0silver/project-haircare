$(document).ready(function () {
          var carts = [{ id: 0, name: '', description: '', image: '', price: 0 }];
          if (readLoacal2() !== null)
                    carts = readLoacal2(); console.log(carts)
          var a = 0;
          var incarts = [{ id: 0, name: '', count: 0, image: '', price: 0 }];
          

        
          if (readLoacal() !== null)
                    incarts = readLoacal(); console.log(incarts);
          count = (value, index) => {
                    
                    incarts[index].count = value;
                    window.localStorage.setItem('incarts', JSON.stringify(incarts));
                    let m = '#total' + index;
                    $(m).val(incarts[index].count * incarts[index].price);
                    window.localStorage.setItem('incarts', JSON.stringify(incarts));
          }
          addtocart = (i) => {

                    $.getJSON('http://localhost:4001/index', function (json) {
                              let count = 1;
                              for (a = 0; a < carts.length; a++) {
                                        if (json[i].id === carts[a].id) {
                                                  count++;
                                                  break;
                                        }
                              }
                              if (count === 1) {
                                        carts.push(json[i]);
                                        incarts.push({ id: Number(json[i].id), name: json[i].name, count: 1, image: json[i].image, price: json[i].price });
                                        viewcart(carts);
                                        console.log(carts[i + 1]);
                                        window.localStorage.setItem('carts', JSON.stringify(carts));
                                        window.localStorage.setItem('incarts', JSON.stringify(incarts));
                                        notice()
                              }
                             

                    });
          }
          remove = (b) => {
                    carts = carts.filter((cart, index, carts) => { return cart.id != b });
                    incarts = incarts.filter((incart, index, carts) => { return incart.id != b })
                    console.log(carts);
                    viewcart(carts);
                    window.localStorage.setItem('incarts', JSON.stringify(incarts));
                    window.localStorage.setItem('carts', JSON.stringify(carts));
                    notice()
          }
          function viewcart(carts) {
                    $('#cart-detail').empty();
                    $('#cartdetail').empty();
                    notice()
                    for (var p = 1; p < carts.length; p++) {

                              var pro = "<tr>";
                              pro += "<td>" + carts[p].id + "</td>";
                              pro += '<td><img src="../image/' + carts[p].image + '" alt=""><p>' + carts[p].name + '</p></td>';
                              pro += "<td><input type='number' style='height:20px;width:50px'' min='1' onchange='count(this.value," + p + ")' value=" + incarts[p].count + " class='quan " + incarts[p].id + "'></td>";
                              pro += "<td><input type='text' style='height:20px;width:50px' id='total" + p + "' value='" + incarts[p].count * carts[p].price + "'disabled></td>";
                              pro += "<td><button onclick='remove(" + carts[p].id + ")' style='width:20px' >" + '<i class="fa-solid fa-xmark" style="color: #ff0000;"></i>' + "</td>";
                              pro += "</tr>";

                              $('#cart-detail').append(pro);
                    };
          }
          function readLoacal() {
                    return JSON.parse(localStorage.getItem('incarts'))
          }
          function readLoacal2() {
                    return JSON.parse(localStorage.getItem('carts'))
          }
          function readAmount() {
                    return localStorage.getItem('amount');
          }

          $('#cart').click(function () {
                    $('.cart-pre').toggle('slow');
                    viewcart(carts);
          })
          const notice = () => {
                    if (carts.length - 1 === 0) { $('#notice').css('background', "rgb(30, 29, 29)"); $('#notice').text(''); }
                    else {
                              $('#notice').css('background', "red");
                              $('#notice').text(carts.length - 1);
                    }
          }
          notice();
          viewcart(carts);
          $('#pay').click(function () {
                    if (carts.length === 1) {
                              alert('No product in cart. Please chose some products!')
                    } else if (carts.length > 1) {
                              url = 'http://127.0.0.1:5500/pay/pay.html';
                              $(location).attr("href", url);
                    }

          });

        
          buy = (i) => {
                    addtocart(i);
                    url = 'http://127.0.0.1:5500/pay/pay.html';
                              $(location).attr("href", url);}
          

          $(window).scroll(function () {
                    if ($(window).scrollTop()>=10){
                    $('body').append('<a id="topup" onclick="up()"><i class="fa-solid fa-arrow-up" style="color: #ffffff;"></i></a>');
                              $('#topup').fadeIn();
                    }
                    else $('#topup').fadeOut();
          });
          up = () => {
                    $(window).scrollTop(0)
          }
          
        
});
