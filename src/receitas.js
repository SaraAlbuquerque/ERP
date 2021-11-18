const Sequelize = require('sequelize');
const sequelize = new Sequelize('erp','root', 'root',{
    host: 'localhost',
    dialect: 'mysql'
});

const Receita = sequelize.define('receitas',{
    incomeId: { 
        type: Sequelize.INTEGER
    },
    incomeAmount: { 
        type: Sequelize.DECIMAL
    },
    earnedDate: { 
        type: Sequelize.DATE
    },
    note: { 
        type: Sequelize.STRING
    },
    jobRole: { 
        type: Sequelize.STRING
    },
    userId: { 
        type: Sequelize.INTEGER
    },
    createdOn: { 
        type: Sequelize.DATE
    },
    deletedOn: { 
        type: Sequelize.DATE
    }
});

Receita.sync({force: true});

