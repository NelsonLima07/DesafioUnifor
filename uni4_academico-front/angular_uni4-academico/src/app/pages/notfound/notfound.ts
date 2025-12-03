import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { AppFloatingConfigurator } from '../../layout/component/app.floatingconfigurator';
import { LayoutService } from '../../layout/service/layout.service';

@Component({
    selector: 'app-notfound',
    imports: [RouterModule, /* AppFloatingConfigurator, */ ButtonModule],
    templateUrl:'./notfound.html'
})

export class Notfound {

    constructor(private layoutService: LayoutService) {
        this.layoutService.toggleDarkMode(this.layoutService.layoutConfig());
    }

}
