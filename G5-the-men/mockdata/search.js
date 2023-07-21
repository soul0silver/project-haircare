$(document).ready(function () {
          $('#search').on('input',function () {
                    let text = $('#search').val().toLowerCase();
                    console.log(text);
                    if (text !== '')
                              $.getJSON('http://localhost:4001/index', function (json) {
                                        $('#res').empty();
                                        $.each(json, function (index, element) {
                                                  
                                                  if (element.name.includes(text)) {
                                                            
                                                            let html = '<div onclick="pick('+index+')"  style="border-bottom:0.5px solid black;margin-bottom:2px;height:100px">'
                                                            html += '<div style="display:flex"><img style="width:80px;height:90px;margin-left:10px" src="../image/' + element.image + '">'
                                                            html+='<div style="width:100%;height:80px;font-size:10pt;line-height:50px"><p style="text-align: center">'+element.name+'</p><p style="text-align: center">$'+ element.price+'.00</p></div>'
                                                            html += ' </div>'
                                                            html += '</div>';
                                                            $('#res').append(html)
                                                  }
                                        });
                              });
                    else $('#res').empty();
          });
          pick = (i) => {
                    let url = 'http://127.0.0.1:5500/products/production.html';
                    var now = window.location.href;
                    if (now === url) show(i); 
                    else  if (now !== url) {
                              $(location).attr('href', url);
                              
                    } 
          }
         
})