const express = require('express');
const app = express();

app.get('/', (req, res)=>{
    return res.json({message:'Seja bem vindo'});
});







app.listen(8081, function(){
    console.log('Servidor rodando');
});