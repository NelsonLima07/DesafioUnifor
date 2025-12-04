import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { AppFloatingConfigurator } from '../../layout/component/app.floatingconfigurator';
import { LayoutService } from '../../layout/service/layout.service';

@Component({
    selector: 'app-links',
    imports: [RouterModule, /* AppFloatingConfigurator, */ ButtonModule],
    templateUrl:'./suporte.html'
})

export class SuporteComponent {

    constructor(private layoutService: LayoutService) {
        this.layoutService.toggleDarkMode(this.layoutService.layoutConfig());
    }

}
